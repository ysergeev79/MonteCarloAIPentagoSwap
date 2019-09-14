  
    A Monte-Carlo Implementation of a variation of the game Pentago
  
  The goal of the assigned project required for exploration of artificial intelligence
algorithms and how they behave in direct practical application, as opposed to theory.
The game on which this exploration would be carried out was Pentago-Swap, a different
variation on the game Pentago, which in itself lies in the category of Moku games.
Pentago is a zero-sum, perfect information, two-player game, which insists that every
player’s gains are equal to the opponent’s losses and all is generally known about the
current game state. Albeit, the large state space, and the ability to swap two quadrants
at every move, significantly raises the complexity as well as the run-time of state
determination.

  The solution to the task at hand was approached by research and
experimentation in order to output the best result as well as have a basis of comparison
from which a concrete solution would be deemed better than another. Due to the
general popularity of such a family of boardgames, many resources and research
papers have laid out the approximation of traditional Pentago’s state-space and
game-tree complexity, from which Pentago-Swaps complexity may be inferred.
Given that the maximum number of moves that may be made on the board is 36, we
can infer the depth of the potential game-tree to be d = 36. To further estimate the
structure of the tree, we may note the branching factor to signify the number of possible
moves per every game state [1].

  Undoubtedly, any such game may be solvable, given an infinite amount of time
and the opportunity to walk through the whole structure of the game tree. However due
to general time constraints, and additional time constraints put on the tournament,
algorithms had to be applied to reduce the problem and solution size. Under this
consideration, Alpha-Beta pruning search seemed at first glance to be the most optimal
approach, given that it takes into consideration the opponent’s optimal plays. Alpha-beta
is a depth-first search, extending from the minimax algorithm, based on the pruning of
unnecessary sub-trees of the game tree. Given a state, the algorithm expands a
game-tree until a certain depth. The values of the leaves at that depth are set according
to an identified heuristic that gives a value to the possible board configuration, as a
basis of comparison. Ideally, winning positions will be provided with a high rating, whilst
positions that lead to loss will be rated lower, with draws extrapolated by the heuristic at
hand [1].

  Depending on the turn of the player, the values of the states will be set to
maximizing or minimizing (with maximization performed by first player, and minimization
performed by the second).The results are back propagated to the root, with the
implementation of the most optimal heuristic function being key, as the result of the
algorithm could be perfect if it were to return the correct theoretical game value.
Alpha-beta additionally saves time by avoiding visiting needless nodes that do not affect
the result.

  This Alpha beta approach was considered. The minimax algorithm in its bare
structure was implemented, but figuring out a solid heuristic was where the difficulty
essentially lied. What seemed most simple and straightforward was to evaluate the
boards based on how many marbles where in-line, therefore positions with more in-line
marbles of the desired color, were valued more. This simple implementation, always
beat the random player in the number of times played. However, though alpha-beta
search in theory could return a perfect solution had it had a perfect heuristic and gone to
the full depth of d=36, in practice a depth greater than 2 could not be fostered. In order
to make the AI agent under this algorithm and constraint potentially outperform a human
player or a stronger AI agent, the algorithm would have need firstly a more perfect
heuristic, and an optimization and alteration of the depth, as the state space is reduced
per play: thus, a potential solution would be to increase the depth size, the lower the
algorithm gets in its tree. However, even then perhaps the max elongation would be up
to depth 3, simply due to the exponential computational time as depth increases.
The downfalls of Alpha-beta led to the implementation of the Monte Carlo Tree
Search for the Pentago AI agent. Due to such a high branching factor of the
Pentago-Swap game tree, this algorithm has been thoroughly considered for the field of
Go playing programs [2]. Moreover, the advantages of Monte-Carlo Tree Search are the
lack of requirements for game-specific knowledge or a heuristic that would evaluate
every board state. In addition, the run may be stopped at a configured time so that the
playout conform to the time constraint.

  The Monte Carlo Tree Search works on the basis of random game simulations of
each possible position made from the current parent board state. The algorithm
implemented kept statistics of all nodes run, and then applied the Upper Confidence
Bound to them, in order to identify a confidence interval for wins played out by each
node from the simulated plays. To balance out the fact that not all nodes get the same
number of simulations, nodes with more simulations have a more narrow confidence
interval, as opposed to the ones with fewer simulations. And so, eventually, the
confidence of the nodes with less simulations will widen throughout the playouts, and
they may emerge with upper bounds higher than those initially chosen to be the most
promised nodes. Essentially, this depicts what is known as the exploration/exploitation
problem, and the formula is given as follows:
Where,
w is the number of simulated wins from the given node.
n is the number of total simulations that were run for the given node
c is the exploration parameter which was √2.
t is the number of total simulations that have occured from the ith move [3].
The implemented MCTS for Pentago-Swap functions like the standard algorithm,
by carrying out the selection of a node, expanding it further and simulating games, and
then back propagating the result. The code was structured in such a way as to contain a
HashMap that would keep track of the points allotted to player one and player two.
Depending on the outcome of a simulation, 1 point would be added to a winner, a -1 to
the loser, with a 0 for a draw. The simulations played were performed by two random
players performing random moves. The structure of the code was very simple with
classes for the MCTS algorithm, the node data structure, score data structure, and a
simulated rollout algorithm.

  The MCTS algorithm proved to be very effective, with a time set for 1000
milliseconds to carry out all four steps of the MCTS. Another advantage was that it
would not timeout, as opposed to the Alpha Beta. This randomized approach ended up
beating most Alpha Beta agents, even with the most intricate heuristics. The power of
the MCTS essentially lies in the randomness of plays, considering that not all agents
actually play most optimally, and it has more luck going deeper in a tree.
Many ideas were considered for further optimizing the most basic MCTS agent.
There seemed to be power in the randomness, however, if the opponent’s plays are to
be idealistic and optimal, it was firstly considered to try and optimize the random
rollouts. A side brushed upon was getting the rollouts to implement a heuristic search
like Alpha Beta, however that was not possible due to the computational constraints. A
hypothesis touched upon was also maybe getting the agent to play the rollouts as itself
against itself, as it gets smarter over the course of a few simulations. However, that
approach was similarly scrapped due to the fact it swayed of multithreading at the initial
stages of thought. Another optimization approach considered was the building of a
Monte Carlo- Alpha Beta hybrid, which would allow for the increase in depth of the
Alpha Beta once the available board states were quickly reduced from the MCTS.
Therefore after half the plays performed by MCTS, we could take advantage of a good
heuristic and a depth greater than 2 to quickly find a win. The question was when would
we do the algorithm switch? At what tree depth would this be most optimal and useful?
This may be further explored as a future improvement.
  
    Finally, the first-player guaranteed win approach was used to optimize the plays
of the agent when it plays first. Undoubtedly, the agent could be guaranteed a win in
five moves if it always brings the board back to its desired configuration. In the
implementation, the agent always puts the first marble in the center tile of the top-right
quadrant, and then aims to fill a line of five in the top row. This is achieved by taking
care of all possible cases and then bringing the quadrants and tiles back to that upper
horizontal line. As long as the top horizontal center line is not occupied by two opponent
marbles, the win can be achieved. Many cases were already considered, however for
future optimization, test cases may be written in order to test all possible configurations
and make sure that surely all the board configurations were taken into account.
Moreover, instead of focusing on the sole horizontal top line, the building of the winning
line could be taken to another configuration if it so happens that the opponent aims to
block the horizontal and puts two black marbles in the build of the winning line.
Furthermore, this approach, at the given moment, is only applicable for the first player.
Therefore, for further optimization, a similar algorithm could be implemented for the
second player who’s goal would be to block the winning build lines of the first player.
After all, this first-player win approach almost guarantees the win of the first player, as
long as it is not blocked, and as long as it is optimally implemented and all test cases
are considered.

[1] Ke.tu-darmstadt.de. (2019). [online] Available at:
https://www.ke.tu-darmstadt.de/lehre/arbeiten/bachelor/2011/Buescher_Niklas.pdf [Accessed 20
Mar. 2019].

[2] Bradberry, J. (2019). Introduction to Monte Carlo Tree Search - Jeff Bradberry. [online]
Jeffbradberry.com. Available at:
https://jeffbradberry.com/posts/2015/09/intro-to-monte-carlo-tree-search/ [Accessed 20 Mar.
2019].

[3] Medium. (2019). Tic Tac Toe at the Monte Carlo. [online] Available at:
https://medium.com/swlh/tic-tac-toe-at-the-monte-carlo-a5e0394c7bc2 [Accessed 20 Mar. 2019].
