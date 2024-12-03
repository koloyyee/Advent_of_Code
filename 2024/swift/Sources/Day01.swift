import Foundation

@main
struct Day01 {
	public static func main() {
		if let text = readFile("01.txt") {
			pt1PP(text)
		
		} else {
			print("Failed to read file")
		}
	}

	static func pt1PP(_ text: String) {
					var firsts = [Int]()
			var lasts = [Int]()
			let lines = text.split(separator: "\n")
			for line in lines {
				if #available(macOS 13.0, *) {
					let subseq = line.split(maxSplits: 2,  whereSeparator: \.isWhitespace)
					if let seqFirst = subseq.first {
						if let first = Int(seqFirst) {
							firsts.append(first)
						}
					}
					if let seqLast = subseq.last {
						if let last = Int(seqLast) {
							lasts.append(last)
						}
					}
				} else {
					// Fallback on earlier versions
				}
			}
			firsts.sort()
			lasts.sort()
			var sum = 0;
			for (index, _) in firsts.enumerated() {
				sum += abs(firsts[index] - lasts[index])
			}
			print(sum)
	}
}

let d1 = Day01()
