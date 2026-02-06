// write a logic to add numbers
function add(a, b) {
    return a + b;
}

console.log(add(20,30));

function isPrime(n) {
    if (n <= 1) {
        return false;
    }
    for (let i = 2; i <= Math.sqrt(n); i++) {
        if (n % i === 0) {
            return false;
        }
    }
    return true;
}
console.log(isPrime(11));
console.log(isPrime(1));