import './Counter.css'
import {useState} from "react";
import {CounterButton} from "./CounterButton";

function Counter() {
    const [count, setCount] = useState(0)

    function incrementParent(by) {
        setCount(count + by);
    }

    function decrementParent(by) {
        setCount(count - by);
    }

    return (
        <div className="Counter">
            <CounterButton by={1}
                           incrementParent={incrementParent}
                           decrementParent={decrementParent}/>
            <CounterButton by={2}
                           incrementParent={incrementParent}
                           decrementParent={decrementParent}/>
            <CounterButton by={5}
                           incrementParent={incrementParent}
                           decrementParent={decrementParent}/>
            <span className="totalCount">{count}</span>
            <br/>
            <button className="resetButton" onClick={() => setCount(0)}>reset</button>
        </div>
    );
}


export default Counter;