user1=input("1st player's name")
user2=input("2nd player's name")

user1_ans=input(user1 + "do you want to choose rock, paper or scissors?")
user2_ans=input(user2 + "do you want to choose rock, paper or scissors?")

if user1_ans==user2_ans:
    print("its a tie")
elif user1_ans=='rock':
    if user2_ans=='scissors':
        print("rock wins")
    else:
        print("paper wins")
elif user1_ans=='scissors':
    if user2_ans=='paper':
            print("scissors wins")
    else:
        print("rock wins")
elif user1_ans=='paper':
    if user2_ans=='rock':
            print("paper wins")
    else:
        print("scissors wins")
else:
        print("invalid input")







