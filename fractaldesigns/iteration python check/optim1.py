def getlist(x):
    floo = []
    for i in range(x):
        floo.append(False)
    return floo

def check(lis):
    for i in lis:
        if lis[i] == False:
            return False
    return True

counter = 0
x = 1

stag = 15
end = 25

stage = 2**stag
cap = 2**end + 1

placeholder = getlist(stage)

while stage < cap:
    counter += 1
    x = (x + counter - 1)%stage
    placeholder[x] = True
    
    if(counter >= stage):
        x = 1
        counter = 0
        print 'stage:', stag, stage, check(placeholder)
        
        stage = stage*2
        stag += 1
        if (stage < cap):
            placeholder = getlist(stage)
