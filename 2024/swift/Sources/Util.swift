import Foundation

func readFile(_ fileName: String) -> String? {
    let fileURL = URL(fileURLWithPath: "Inputs/\(fileName)")
    return try? String(contentsOf: fileURL, encoding: .utf8)
}

// func stringToInts(paragraph : String) {
// 	let lines = paragraph.split(separator: "\n")

// 	for line in lines {
// 		if #available(macOS 13.0, *) {
// 		    let spaces = /\\d+/
// 				let s = line.split(separator: /\s+/)
// 				print(s[0])

// 		} else {
// 		    // Fallback on earlier versions
// 		} 
// 	}
// }
