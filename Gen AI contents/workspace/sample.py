# Write a Python function to check if a number is prime. 
def is_prime(n):
    """Check if a number is prime."""
    if n <= 1:
        return False
    for i in range(2, int(n**0.5) + 1):
        if n % i == 0:
            return False
    return True

print(is_prime(1))  # Example usage

# convert this function to javascript
# function isPrime(n) {
#     if (n <= 1) {
#         return false;
#     }
#     for (let i = 2; i <= Math.sqrt(n); i++) {
#         if (n % i === 0) {
#             return false;
#         }
#     }
#     return true;
# }

