require 'xcodeproj'

project_path = 'ios/opensleep/opensleep.xcodeproj'
project = Xcodeproj::Project.open(project_path)

project.targets.each do |target|
  if target.name == 'opensleep'
    target.build_configurations.each do |config|
      ldflags = config.build_settings['OTHER_LDFLAGS'] || []
      ldflags = [ldflags] if ldflags.is_a?(String)
      unless ldflags.include?('-all_load')
        ldflags << '-all_load'
      end
      config.build_settings['OTHER_LDFLAGS'] = ldflags
    end
  end
end

project.save
puts "Successfully added -all_load to OTHER_LDFLAGS for opensleep target."
