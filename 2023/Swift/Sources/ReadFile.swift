import Foundation

func readFile(filename: String) -> [String] {
	var filelines = [String]()
	if let fileURL = Bundle.main.url(forResource: filename, withExtension: "txt") {
		if let fileContent = try? String(contentsOf: fileURL) {
			filelines = fileContent.components(separatedBy: "\n")
		}
	}
	return filelines
}
