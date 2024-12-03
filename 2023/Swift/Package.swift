// swift-tools-version:5.3
import PackageDescription

let package = Package(
	name: "AoC",
	products: [
		.library(name: "Utils", targets: ["AoC"]),
		.executable(name: "AoC", targets: ["AoC"]),
	],
	targets: [
		.target(
			name: "AoC",
			dependencies: [],
			resources: [
				.process("Resources")
			]
		)

	]

)
