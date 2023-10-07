# Get number of columns
C = int(input())

# Stores tiles
arr = []

# Gets tiles
for _ in range(2):
    arr.append([int(i) for i in input('').split()])
    
# Stores answer
ans=0
    
# Iterate over rows
for r in range(2):
    
    # Iterate over columns
    for c in range(C):
        
        # Skip to next iteration of no spill on this tile
        if arr[r][c]==0:
            continue
        
        # Check left side of triangle
        if c==0 or arr[r][c-1]==0:
            ans+=1
            
        # Check right side of triangle
        if c==C-1 or arr[r][c+1]==0:
            ans+=1
        
        # Check if it is a
        # /\
        # \/
        # triangle
        if c%2==0:
            
            # Check if other triangle in this column is not spilled on
            if arr[(r+1)%2][c]==0:
                ans+=1
                
        # It is a
        # \/
        # /\
        # triangle
        else:
            ans+=1

# Output
print(ans)