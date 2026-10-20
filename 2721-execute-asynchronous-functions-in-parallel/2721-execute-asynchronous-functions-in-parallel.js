/**
 * @param {Array<Function>} functions
 * @return {Promise<any>}
 */
var promiseAll = function(functions) {
    return new Promise((resolve, reject) => {
        let res = new Array(functions.length) ;
        let cnt = 0 ;
        
        if (functions.length === 0) return resolve(res) ;
        
        functions.forEach((fn, idx) => {
            fn().then(val => {
                res[idx] = val ;
                cnt++ ;
                if (cnt === functions.length) {
                    resolve(res) ;
                }
            }).catch(err => {
                reject(err) ;
            }) ;
        }) ;
    }) ;
};

/**
 * const promise = promiseAll([() => new Promise(res => res(42))])
 * promise.then(console.log); // [42]
 */