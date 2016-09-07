def getlist(x):
    floo = []
    for i in range(x):
        floo.append('\n\nFAIL-FAIL-FAIL\n\n') #32000 checks - as if
    return floo

counter = 0
x = 1

stage = 2**5
cap = 2**8

placeholder = getlist(stage)

#there's got to be a better way 
while stage < cap:
    counter += 1
    x = (x + counter - 1)%stage #X1
    #print x, stage
    placeholder[x] = counter
    
    if(counter >= stage):
        x = 1
        counter = 0
        print '\nstage: ', stage, placeholder
        
        stage = stage*2
        if (stage < cap):
            placeholder = getlist(stage)
