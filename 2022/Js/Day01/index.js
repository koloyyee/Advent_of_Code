import fs from 'node:fs'
import path from 'node:path'
import { read } from '../read-path.js'

const __dirname = path.join(process.cwd(), '../../Txts/')
const filename = 'day01.txt'

/**
 *
 * @param {string} dir
 * @param {string} filePath
 */
async function readCaloriesText(dir, filePath) {
	try {
		const data = await fs.readFileSync(dir + filePath, { encoding: 'utf-8' })
		return data
	} catch (error) {
		throw error
	}
}
function part1() {
	read(filename).then((data) => {
		const start = performance.now()
		/** @type {Array<string>} */
		const calories = data.split('\n')
		let result = []
		calories.reduce((prev, curr) => {
			let currCal = parseInt(curr)
			if (currCal) {
				prev += currCal
				return prev
			}
			result.push(prev)
			prev = 0
			return prev
		}, 0)
		const maxCal = Math.max(...result)
		console.log({ maxCal })

		const sumTopThree = result
			.sort((a, b) => b - a)
			.slice(0, 3)
			.reduce((prev, curr) => prev + curr)
		console.log({ sumTopThree })
		console.log(performance.now() - start)
		return maxCal
	})
}
part1()
