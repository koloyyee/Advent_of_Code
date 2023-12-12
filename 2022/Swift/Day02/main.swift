// A Y
// B X
// C Z

// A, X - Rock - 1
// B, Y - Paper - 2
// C, Z - Scissor - 3

// win - 6
// draw - 3
// lose - 0

// This strategy guide predicts and recommends the following:

// In the first round, your opponent will choose Rock (A), and you should choose Paper (Y). This ends in a win for you with a score of 8 (2 because you chose Paper + 6 because you won).
// In the second round, your opponent will choose Paper (B), and you should choose Rock (X). This ends in a loss for you with a score of 1 (1 + 0).
// The third round is a draw with both players choosing Scissors, giving you a score of 3 + 3 = 6.
// In this example, if you were to follow the strategy guide, you would get a total score of 15 (8 + 1 + 6).

import Foundation

let file = "../../Txts/day02.txt"

// this enum once it takes input, it will calculate all the possible values
// scores, draw, win, lose at once.
enum Shape {
  case rock, scissor, paper

  // categorizing
  init(_ rawValue: String) {
    switch rawValue {
    case "A", "X":
      self = .rock
    case "B", "Y":
      self = .paper
    case "C", "Z":
      self = .scissor
    default: fatalError()
    }
  }

  // computed properties to get the scores
  var score: Int {
    switch self {
    case .rock:
      return 1
    case .paper:
      return 2
    case .scissor:
      return 3
    }
  }

  // return .rock / .scissor / .paper
  var draw: Shape {
    return self
  }

  // case for either side to win
  var win: Shape {
    switch self {
    case .rock:
      return .scissor
    case .scissor:
      return .paper
    case .paper:
      return .rock
    }
  }
  // case for either side to lose
  var lose: Shape {
    switch self {
    case .rock:
      return .paper
    case .scissor:
      return .rock
    case .paper:
      return .scissor
    }
  }
}

final class Day02 {
  private typealias Hands = (opponent: Shape, mine: Shape)
  private let rounds: [Hands]

  init(filePath: String) {
    let path = Bundle.main.path(forResource: filePath, ofType: nil)!
    let text = try! String(contentsOfFile: path, encoding: String.Encoding.utf8).trimmingCharacters(
      in: .whitespaces)

    var lines = text.components(separatedBy: "\n")
    lines.remove(at: lines.count - 1)

    self.rounds = lines.map { line in
      let parts = line.components(separatedBy: " ")

      return (opponent: Shape(parts[0]), mine: Shape(parts[1]))
    }
  }

  private func fight(_ hands: Hands) -> Int {

    if hands.opponent.draw == hands.mine {
      print("draw: \(hands.opponent), \(hands.mine)")
      return 3
    } else if hands.opponent.lose == hands.mine {
      print("lose: \(hands.opponent), \(hands.mine)")
      return 6
    } else {
      assert(hands.opponent.win == hands.mine)
      print("win: \(hands.opponent), \(hands.mine)")
      return 0
    }
  }

  private func choose(_ hands: Hands) -> Shape {

    switch hands.mine {
    case .paper:
      return hands.opponent.draw
    case .rock:
      return hands.opponent.win
    case .scissor:
      return hands.opponent.lose
    }

  }

  func part1() -> Int {
    rounds.reduce(0) {
      $0 + $1.mine.score + fight($1)
    }
  }

  func part2() -> Int {
    rounds.reduce(0) {
      let mine = choose($1)
      return $0 + mine.score + fight((opponent: $1.opponent, mine: mine))
    }
  }

}

let day02 = Day02(filePath: file)
print(day02.part1())
print(day02.part2())
