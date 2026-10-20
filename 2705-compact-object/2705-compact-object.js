/**
 * @param {Object|Array} obj
 * @return {Object|Array}
 */
var compactObject = function(obj) {
    if (obj === null || typeof obj !== "object") {
        return obj ;
    }
    if (Array.isArray(obj)) {
        let res = [] ;
        for (let item of obj) {
            let val = compactObject(item) ;
            if (Boolean(val)) {
                res.push(val) ;
            }
        }
        return res ;
    }
    
    let res = {} ;
    for (let key in obj) {
        let val = compactObject(obj[key]) ;
        if (Boolean(val)) {
            res[key] = val ;
        }
    }
    return res ;
};