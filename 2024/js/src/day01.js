import { readFile } from "./util.js";

async function pt1PP() {
	let lines = await readFile("01.txt");
	const firsts = [];
	const lasts = [];
	for (let line of lines) {
		const splitStrings = line.split(/\s+/);
		firsts.push(splitStrings[0]);
		lasts.push(splitStrings[1]);
	}
	firsts.sort();
	lasts.sort();
	let sum = 0;
	for (const index in firsts) {
		sum += Math.abs(firsts[index] - lasts[index]);
	}
	console.log(sum);
	return sum;
}

async function pt1FP() {
	let lines = await readFile("01.txt");
	const firsts = lines.map((line) => line.split(/\s+/)[0]).sort();
	const lasts = lines.map((line) => line.split(/\s+/)[1]).sort();
	const sum = firsts.reduce((acc, _, index) => {
		acc += Math.abs(firsts[index] - lasts[index]);
		return acc;
	}, 0);
	console.log(sum);
	return sum;
}

pt1PP();
pt1FP();
