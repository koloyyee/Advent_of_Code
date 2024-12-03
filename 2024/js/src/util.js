import fs from "node:fs/promises";

/**
 *
 * @param {string} filename
 * @returns { [string]}
 */
export async function readFile(filename) {
	let data = await fs.readFile("inputs/" + filename, {encoding : "utf-8"}) 	
	let lines = data.split("\n");
	return lines;
}

export function splitLines(lines) {
	return lines.map(line => line.split(/\s+/));
}

export function stringToInt(line ) {
	return line.map( el => {
		return Number.parseInt(el)
	}) 
}

(async() => {
	splitLines(await readFile("01.txt"))
	.map( line => {
		
	})
})();
