/**
 * @param {Array} arr
 * @param {number} depth
 * @return {Array}
 */
var flat = function (arr, n) {
    if (n === 0) return arr ;
    let res = [] ;
    
    function dfs(curArr, depth) {
        for (let x of curArr) {
            if (Array.isArray(x) && depth < n) {
                dfs(x, depth + 1) ;
            } else {
                res.push(x) ;
            }
        }
    }
    
    dfs(arr, 0) ;
    return res ;
};