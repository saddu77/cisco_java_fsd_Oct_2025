// write a testcase using mocha and chai to test a function that adds two numbers

const chai = require('chai');
const expect = chai.expect;

// Function to add two numbers
function add(a, b) {
    return a + b;
}

// Test suite for the add function
describe('add', function() {
    it('should return the sum of two positive numbers', function() {
        const result = add(2, 3);
        expect(result).to.equal(5);
    });

    it('should return the sum of a positive and a negative number', function() {
        const result = add(5, -2);
        expect(result).to.equal(3);
    });

    it('should return the sum of two negative numbers', function() {
        const result = add(-4, -6);
        expect(result).to.equal(-10);
    });

    it('should return zero when adding zero to zero', function() {
        const result = add(0, 0);
        expect(result).to.equal(0);
    });

    it('should return the same number when adding zero', function() {
        const result = add(7, 0);
        expect(result).to.equal(7);
    });
});