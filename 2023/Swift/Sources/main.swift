// The Swift Programming Language
// https://docs.swift.org/swift-book
import Foundation


struct Day1 {
    let path = FileManager.default.currentDirectoryPath + "/Sources/Resources/day01.txt"
    var lines: [String] = []

    init() {
        do {
            // Get the contents
            let contents = try String(contentsOfFile: path, encoding: .utf8)
            lines = contents.components(separatedBy: .newlines)

        } catch let error as NSError {
            print("Can't find file.\(error)")
        }
    }
    func part1() -> Int {
        return lines.reduce(0) { acc, line in
            let digits = line.map { $0 }.compactMap { $0.wholeNumberValue }
            return acc + digits.first! * 10 + digits.last!
        }

    }
}

let d = Day1()
print(d.part1())
