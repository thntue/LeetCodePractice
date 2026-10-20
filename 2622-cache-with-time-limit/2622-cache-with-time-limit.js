var TimeLimitedCache = function() {
    
};

/** 
 * @param {number} key
 * @param {number} value
 * @param {number} duration time until expiration in ms
 * @return {boolean} if un-expired key already existed
 */
var TimeLimitedCache = function() {
    this.cache = new Map() ;
};

TimeLimitedCache.prototype.set = function(key, value, duration) {
    let exists = this.cache.has(key) ;
    if (exists) {
        clearTimeout(this.cache.get(key).timer) ;
    }
    let timer = setTimeout(() => {
        this.cache.delete(key) ;
    }, duration) ;
    
    this.cache.set(key, { value: value, timer: timer }) ;
    return exists ;
};

TimeLimitedCache.prototype.get = function(key) {
    if (this.cache.has(key)) {
        return this.cache.get(key).value ;
    }
    return -1 ;
};

TimeLimitedCache.prototype.count = function() {
    return this.cache.size ;
};
/**
 * const timeLimitedCache = new TimeLimitedCache()
 * timeLimitedCache.set(1, 42, 1000); // false
 * timeLimitedCache.get(1) // 42
 * timeLimitedCache.count() // 1
 */