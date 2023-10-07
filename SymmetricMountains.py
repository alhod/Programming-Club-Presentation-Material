# Get number of mountains
N = int(input())

# Get mountain heights
h = [int(i) for i in input().split()]

# Answer array
ans = []

# Populate array
for i in range(N):
    
    # Java's integer max value
    ans.append(2147483647)
    
# Iterate over mountains (for even crop values)
for i in range(N):
    
    # Store cumulative asymmetric value for this index
    crop_val = 0
    
    # Iterate over crop values (increment by 2)
    crop=0
    while i-crop//2>=0 and i+crop//2<N:
        
        # Calculate absolute difference, add to cumulative asymmetric value
        crop_val+=abs(h[i-crop//2]-h[i+crop//2])
        
        # Compare minimum asymmetric value for this crop with current cumulative asymmetric value
        ans[crop]=min(ans[crop], crop_val)
        
        # Increment crop by 2
        crop+=2
        
# Iterate over mountains (for odd crop values)
for i in range(N):
    
    # Store cumulative asymmetric value for this index
    crop_val = 0
    
    # Iterate over crop values (inceremnt by 2), this time starting at 1 (since odd crop values)
    crop=1
    while i-crop//2>=0 and i+crop//2+1<N:
        
        # Calculate absolute difference, add to cumulative asymmetric value
        crop_val+=abs(h[i-crop//2]-h[i+crop//2+1])
        
        # Compare minimum asymmetric value for this crop with current cumulative asymmetric value
        ans[crop]=min(ans[crop], crop_val)
        
        # Increment crop by 2
        crop+=2
        
# Output
for i in range(N):
    print(ans[i], end=" ")
        
    