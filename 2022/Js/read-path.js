import fs from 'node:fs'
import path from 'path'

export async function read(filename) {
	try {
		const dir = path.join(process.cwd(), '../../Txts/')
		const file = dir + filename
		let result = await fs.readFileSync(file, 'utf-8')
		return result
	} catch (error) {
		throw error
	}
}
