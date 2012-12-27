def vals = []
def thirds = []
int tIdx = 0

thirds[0] = 0

new File("in.txt").eachLine { line ->

	List chars = line.tokenize('.')

	vals.addAll(chars)

}

vals.eachWithIndex { c, idx ->
	if (idx > 0 && idx % 3 == 0) {
		//println "finished: ${thirds[tIdx]}"
		tIdx++
		thirds[tIdx] = 0
	}

	thirds[tIdx] += c.toInteger()
}

def histogram = [:]

thirds.each {
	if(!histogram[it]) {
		histogram[it] = 1
	}
	else {
		histogram[it]++
	}
}

def mostFrequent = 0

histogram.entrySet().each {
	//println "k: ${it.getKey()} , v: ${it.getValue()}"
	if(it.getValue() > histogram[mostFrequent]) {
		mostFrequent = it.getKey()
	}
}

def possibleKey = mostFrequent - 32

//println possibleKey

def newVals = []

thirds.eachWithIndex {c, idx ->
	newVals[idx] = (char)(c - possibleKey);
}



newVals.each {
	print it
}

//println mostFrequent

//println histogram

//println thirds

