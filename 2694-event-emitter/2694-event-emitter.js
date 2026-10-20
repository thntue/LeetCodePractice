class EventEmitter {
    constructor() {
        this.events = {} ;
    }
    
    subscribe(eventName, callback) {
        if (!this.events[eventName]) {
            this.events[eventName] = [] ;
        }
        this.events[eventName].push(callback) ;
        
        return {
            unsubscribe: () => {
                let idx = this.events[eventName].indexOf(callback) ;
                if (idx !== -1) {
                    this.events[eventName].splice(idx, 1) ;
                }
            }
        } ;
    }
    
    emit(eventName, args = []) {
        if (!this.events[eventName]) {
            return [] ;
        }
        return this.events[eventName].map(fn => fn(...args)) ;
    }
}

/**
 * const emitter = new EventEmitter();
 *
 * // Subscribe to the onClick event with onClickCallback
 * function onClickCallback() { return 99 }
 * const sub = emitter.subscribe('onClick', onClickCallback);
 *
 * emitter.emit('onClick'); // [99]
 * sub.unsubscribe(); // undefined
 * emitter.emit('onClick'); // []
 */