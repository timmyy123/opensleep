//
//  Item.swift
//  opensleep
//
//  Created by timmybrown on 30/5/2026.
//

import Foundation
import SwiftData

@Model
final class Item {
    var timestamp: Date
    
    init(timestamp: Date) {
        self.timestamp = timestamp
    }
}
