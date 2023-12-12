package main

import (
	"os"
)

func check(err error) {
	if err != nil {
		panic(err)
	}
}

func main() {
	filePath := "../../Txts/day01.txt"
	data, err := os.ReadFile(filePath)
	check(err)
	file, err := os.Open(filePath)
}
