require 'xcodeproj'

project_path = 'ios/opensleep/opensleep.xcodeproj'
project = Xcodeproj::Project.open(project_path)

# Find the main target
target = project.targets.find { |t| t.name == 'opensleep' }

# Remove remote LiteRTLM package reference
project.root_object.package_references.delete_if do |ref|
  ref.repositoryURL && ref.repositoryURL.include?('LiteRT-LM')
end

# Remove any remote package product dependencies for LiteRTLM
target.package_product_dependencies.delete_if do |dep|
  dep.product_name == 'LiteRTLM'
end

# Add the local package
local_pkg = project.new(Xcodeproj::Project::Object::XCLocalSwiftPackageReference)
local_pkg.relative_path = "LocalPackages/LiteRT-LM"
project.root_object.package_references << local_pkg

# Add product dependency to target
product_dep = project.new(Xcodeproj::Project::Object::XCSwiftPackageProductDependency)
product_dep.product_name = "LiteRTLM"
product_dep.package = local_pkg
target.package_product_dependencies << product_dep

# Ensure the framework build phase includes the package product
frameworks_build_phase = target.frameworks_build_phase
existing_build_file = frameworks_build_phase.files.find { |file| file.product_ref == product_dep }
unless existing_build_file
  build_file = project.new(Xcodeproj::Project::Object::PBXBuildFile)
  build_file.product_ref = product_dep
  frameworks_build_phase.files << build_file
end

project.save
puts "Successfully replaced remote LiteRTLM with local package reference."
