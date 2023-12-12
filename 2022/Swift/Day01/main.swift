import Foundation

class Day1 {
    private let calories: [[Int]]

    init(filePath: String) {
        let path = Bundle.main.path(forResource: filePath, ofType: nil)!
        let caloriseInText = try! String(contentsOfFile: path, encoding: String.Encoding.utf8) 
        let groups = caloriseInText.components(separatedBy: "\n\n") // this is where the visible empty line
        self.calories = groups.map {
            $0.components(separatedBy: .newlines).map { // the \n between each string int
                return Int($0) ?? 0
            }
        }
    }

    private func sortedCalories () -> [Int] {
        return  calories
        .map {$0.reduce( 0, +)}
        .sorted(by: >)
        
    }

    func part1() -> Int{
        let sortedCalories = sortedCalories()
        return sortedCalories.prefix(3).max()!
    }

    func part2() -> Int {
        let sortedCalories = sortedCalories()
        return sortedCalories.prefix(3).reduce(0, +)
    }
}

let day1b = Day1(filePath: "../../Txts/day01.txt")
print(day1b.part1())
print(day1b.part2())
