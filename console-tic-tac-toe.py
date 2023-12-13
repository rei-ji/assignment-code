"""
Programme is a game of computer versus human tic-tac-toe

Game starts with welcoming the player and generating an empty game board
It then prompts the player for their move and generates a computer move in response
Both the player's and the computer's move will then be displayed on the board and recorded in a log file
With each turn, the program will check for winning, losing and tie condition
The programme will loop itself until one of the condition is met
An appropriate message will be displayed based on which condition is met
After a game ends, the programme will ask if the player would like to play again
If the player wants to play again, the programme will loop itself
Otherwise, the programme ends

Utilises techniques such as lists, for and while loops, if-else statements, random library and so on
"""

# Initialise variables
board = [" ", " ", " ",
         " ", " ", " ",
         " ", " ", " "]
win = False
lose = False
tie = False
player = "X"
computer = "O"
playAgain = "Y"

# Generate game board
def generateBoard(board):
    for row in range(1, 9):
        if row == 2:
            print("   " + board[0] + "   //   " + board[1] + "   //   " + board[2] + "   ")
        if row == 5:
            print("   " + board[3] + "   //   " + board[4] + "   //   " + board[5] + "   ")
        if row == 8:
            print("   " + board[6] + "   //   " + board[7] + "   //   " + board[8] + "   ")
        if row == 3 or row == 6:
            print("/////////////////////////")
        else:
            print ("       //       //       ")
        row += 1

# Prompt the user for their move
def promptPlayerMove(turn):
    print("Turn:", turn)
    print("Where would you like to place an X?")

    # Prompt row input
    row = int(input("Row (1 to 3): "))

    # Check if row is valid
    while row <= 0 or row > 3:
        print("Invalid input. Please enter a number from 1 to 3.")
        row = int(input("Row (1 to 3): "))

    # Prompt column input
    column = int(input("Column (1 to 3): "))

    # Check if column is valid
    while column <= 0 or column > 3:
        print("Invalid input. Please enter a number from 1 to 3.")
        column = int(input("Column (1 to 3): "))

    # Define position to return value
    position = (row, column)

    return position

# Check if position chosen is valid and not occupied
def checkPlayerMove(player, row, column, turn):
    if row == 1:
        if column == 1 and board[0] == " ":
            board[0] = player
        elif column == 2 and board[1] == " ":
            board[1] = player
        elif column == 3 and board[2] == " ":
            board[2] = player
        else:
            # Prompt different move if invalid
            print("Oops, that space is occupied! Please choose another one.\n")
            row, column = promptPlayerMove(turn)
            checkPlayerMove(player, row, column, turn)

    elif row == 2:
        if column == 1 and board[3] == " ":
            board[3] = player
        elif column == 2 and board[4] == " ":
            board[4] = player
        elif column == 3 and board[5] == " ":
            board[5] = player
        else:
            # Prompt different move if invalid
            print("Oops, that space is occupied! Please choose another one.\n")
            row, column = promptPlayerMove(turn)
            checkPlayerMove(player, row, column, turn)

    elif row == 3:
        if column == 1 and board[6] == " ":
            board[6] = player
        elif column == 2 and board[7] == " ":
            board[7] = player
        elif column == 3 and board[8] == " ":
            board[8] = player
        else:
            # Prompt different move if invalid
            print("Oops, that space is occupied! Please select another one.\n")
            row, column = promptPlayerMove(turn)
            checkPlayerMove(player, row, column, turn)

    # Define position to return value
    position = (row, column)

    return position

# Computer move
def computerMove():
    import random

    # Randomise computer move
    row = random.randint(1, 3)
    column = random.randint(1, 3)

    # Define position to return value
    position = (row, column)

    return position

# Check if computer move is valid and doesn't choose occupied space
def checkComputerMove(row, column, computer):
    if row == 1:
        if column == 1 and board[0] == " ":
            board[0] = computer
        elif column == 2 and board[1] == " ":
            board[1] = computer
        elif column == 3 and board[2] == " ":
            board[2] = computer
        else:
            # Generate new move if invalid
            row, column = computerMove()
            row, column = checkComputerMove(row, column, computer)

    elif row == 2:
        if column == 1 and board[3] == " ":
            board[3] = computer
        elif column == 2 and board[4] == " ":
            board[4] = computer
        elif column == 3 and board[5] == " ":
            board[5] = computer
        else:
            # Generate new move if invalid
            row, column = computerMove()
            row, column = checkComputerMove(row, column, computer)

    elif row == 3:
        if column == 1 and board[6] == " ":
            board[6] = computer
        elif column == 2 and board[7] == " ":
            board[7] = computer
        elif column == 3 and board[8] == " ":
            board[8] = computer
        else:
            # Generate new move if invalid
            row, column = computerMove()
            row, column = checkComputerMove(row, column, computer)

    # Define position to return value
    position = (row, column)

    return position

# Generate log file
def createLog(playerRow, playerColumn, turn, computerRow, computerColumn, player, computer, win):
    # Write new log file
    if turn == 1:
        log = open("logfile.txt", "w")
        log.write(str(turn) + ", H, " + str(playerRow) + ", " + str(playerColumn) + ", " + player + "\n")
        log.write(str(turn) + ", C, " + str(computerRow) + ", " + str(computerColumn) + ", " + computer + "\n")

    # Append available file
    else:
        log = open("logfile.txt", "a")
        log.write(str(turn) + ", H, " + str(playerRow) + ", " + str(playerColumn) + ", " + player + "\n")

        # Ensure no repeat append of extra computer move
        if win is False and tie is False:
            log.write(str(turn) + ", C, " + str(computerRow) + ", " + str(computerColumn) + ", " + computer + "\n")

    log.close()

    return log

# Check for winning condition
def checkWin(win):
    # Check horizontal
    if board[0] == board[1] == board[2] and board[1] != " ":
        win = True
    elif board[3] == board[4] == board[5] and board[4] != " ":
        win = True
    elif board[6] == board[7] == board[8] and board[7] != " ":
        win = True

    # Check vertical
    if board[0] == board[3] == board[6] and board[3] != " ":
        win = True
    elif board[1] == board[4] == board[7] and board[4] != " ":
        win = True
    elif board[2] == board[5] == board[8] and board[5] != " ":
        win = True

    # Check diagonal
    if board[0] == board[4] == board[8] and board[4] != " ":
        win = True
    elif board[2] == board[4] == board[6] and board[4] != " ":
        win = True

    return win

# Check for losing condition
def checkLose(lose):
    # Check horizontal
    if board[0] == board[1] == board[2] and board[1] != " ":
        lose = True
    elif board[3] == board[4] == board[5] and board[4] != " ":
        lose = True
    elif board[6] == board[7] == board[8] and board[7] != " ":
        lose = True

    # Check vertical
    if board[0] == board[3] == board[6] and board[3] != " ":
        lose = True
    elif board[1] == board[4] == board[7] and board[4] != " ":
        lose = True
    elif board[2] == board[5] == board[8] and board[5] != " ":
        lose = True

    # Check diagonal
    if board[0] == board[4] == board[8] and board[4] != " ":
        lose = True
    elif board[2] == board[4] == board[6] and board[4] != " ":
        lose = True

    return lose

# Check for tie condition
def checkTie(tie):
    if len(board) == 9 and turn == 5 and win is False:
        tie = True

    return tie

# Ask user if they would like to retry
def promptPlayAgain(win, lose, tie):
    playAgain = input("Play again? (Y/N) \n")

    # Display randomised starting text depending on results of previous round
    if playAgain.upper() == "Y":
        import random

        winText = ["I won't lose this time!", "You won't defeat me again!", "I'll win this time around!"]
        loseText = ["Good luck beating me this time!", "I won't go easy on you!", "Show me what you're made off!"]
        tieText = ["Let's settle this once and for all!", "Let's find out who's the victor between us this time!",
                   "A rematch it is!"]

        print()

        if win is True:
            print(random.choice(winText))
        elif lose is True:
            print(random.choice(loseText))
        elif tie is True:
            print(random.choice(tieText))

    # Bid farewell if player does not intend to play again
    elif playAgain.upper() == "N":
        print("\nSee you!")

    # Check if valid input, prompt again if not
    else:
        print("Invalid choice! Please enter Y or N.\n")
        playAgain = promptPlayAgain(win, lose, tie)

    return playAgain


# Programme start
# Welcome player to game
print("Let's play Tic-Tac-Toe!")
print("The first to place three Xs or Os in a horizontal, vertical or diagonal row wins!")

# Loop start, end if player no longer wants to play
while playAgain.upper() == "Y":
    # Empty board
    board = [" ", " ", " ",
             " ", " ", " ",
             " ", " ", " "]

    # Reset winning, losing and tie condition
    win = False
    lose = False
    tie = False

    # Reset turn
    turn = 1

    # Display empty board
    generateBoard(board)

    # Loop until win or lose or tie
    while lose is False and win is False and tie is False:
        # Prompt and check player move
        playerRow, playerColumn = promptPlayerMove(turn)
        playerRow, playerColumn = checkPlayerMove(player, playerRow, playerColumn, turn)

        # Check winning and tie condition
        win = checkWin(win)
        tie = checkTie(tie)

        print()

        # Ensure computer doesn't make extra move
        if win is False and tie is False:
            # Generate and check computer move
            computerRow, computerColumn = computerMove()
            computerRow, computerColumn = checkComputerMove(computerRow, computerColumn, computer)

            # Check losing condition
            lose = checkLose(lose)

        # Record in log
        createLog(playerRow, playerColumn, turn, computerRow, computerColumn, player, computer, win)

        # Display board
        generateBoard(board)

        turn += 1

    # Display game results
    if win is True:
        print("You win!")

    elif lose is True:
        print("You lose!")

    elif tie is True:
        print("It's a tie!")

    # Prompt if player would like to play again
    playAgain = promptPlayAgain(win, lose, tie)

# Indicate end of program
print("Thank you for playing!")
