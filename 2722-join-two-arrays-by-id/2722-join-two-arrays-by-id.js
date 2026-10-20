/**
 * @param {Array} arr1
 * @param {Array} arr2
 * @return {Array}
 */
var join = function(arr1, arr2) {
    let map = {} ;
    for (let item of arr1) {
        map[item.id] = item ;
    }
    for (let item of arr2) {
        if (map[item.id]) {
            map[item.id] = Object.assign(map[item.id], item) ;
        } else {
            map[item.id] = item ;
        }
    }
    return Object.values(map) ;
};