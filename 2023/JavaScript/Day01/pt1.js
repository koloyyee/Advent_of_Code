const fs = require("fs");
const process = require("process");

const sample = `
                1abc2
                pqr3stu8vwx
                a1b2c3d4e5f
                treb7uchet
               `; 


function oo(fileLines="") {
	
	try {
		let total = 0;

		const file = fs.readFileSync(process.cwd() + "/input.txt", "utf-8");
		const fileLines = file.split("\n");
		for(const line of fileLines) {
		let first = -1;
		let second = -1;
			for( const char of line) {
				if(!isNaN(char) ) {
					if (first == -1) {
						first  = parseInt(char);
					} else {
						second = parseInt(char);
					}
				}
			}
				if (second == -1) {
					second = first;
				}
				first *= 10;

				total += first + second;
		}
		
		console.log(total);
		return total;
	

		
	} catch (error) {
		console.error(error);
		
	}


	return 1;
}

oo();

