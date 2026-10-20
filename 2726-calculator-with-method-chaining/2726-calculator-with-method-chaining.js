class Calculator {
    constructor(value) {
        this.val = value ;
    }
    
    add(value){
        this.val += value ;
        return this ;
    }
    
    subtract(value){
        this.val -= value ;
        return this ;
    }
    
    multiply(value) {
        this.val *= value ;
        return this ;
    }
    
    divide(value) {
        if (value === 0) {
            throw new Error("Division by zero is not allowed") ;
        }
        this.val /= value ;
        return this ;
    }
    
    power(value) {
        this.val = Math.pow(this.val, value) ;
        return this ;
    }
    
    getResult() {
        return this.val ;
    }
}