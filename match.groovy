// this is you
def you = players.Player1
def opponent = players.Rock

def rounds = 100

def playMatch = { player1, player2 ->
	(1 .. rounds)
		.inject([[], []], { hands, ignore ->
			def hands1 = hands[0]
			def hands2 = hands[1]

			def hand1 = player1.hand(hands1, hands2) % 3
			def hand2 = player2.hand(hands2, hands1) % 3

			[hands1 + hand1, hands2 + hand2]
		})
}

def scoreHand = { hand1, hand2 ->
	(hand1 - hand2 + 4) % 3 - 1
}

def add = { x, y ->
	x + y
}

def scoreMatch = { hands1, hands2 ->
	[hands1, hands2]
		.transpose()
		.collect({ hand ->
			scoreHand(hand[0], hand[1])
		})
}

def match = playMatch(you, opponent)
def yourhands = match[0];
def opponenthands = match[1]
def scorelist = scoreMatch(yourhands, opponenthands)
def score = scorelist.inject(add)

println('match results\n')
println(you.name.split('\\.')[1].padRight(16) + yourhands.join(''))
println(opponent.name.split('\\.')[1].padRight(16) + opponenthands.join(''))
println('score'.padRight(16) + scorelist.collect({ s ->
	if (s == -1) '-' else
	if (s == 1) '+' else
	' '
}).join(''))
println()
println('total'.padRight(16) + score)
