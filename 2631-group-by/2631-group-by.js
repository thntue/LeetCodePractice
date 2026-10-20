/**
 * @param {Function} fn
 * @return {Object}
 */
Array.prototype.groupBy = function(fn) {
    let ans = {} ;
    for (let item of this) {
        let key = fn(item) ;
        if (!ans[key]) {
            ans[key] = [] ;
        }
        ans[key].push(item) ;
    }
    return ans ;
};

/**
 * [1,2,3].groupBy(String) // {"1":[1],"2":[2],"3":[3]}
 */