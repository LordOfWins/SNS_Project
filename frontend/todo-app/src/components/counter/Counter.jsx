import './Counter.css'
import {useState} from "react";

function Counter() {

    const [count, setCount] = useState(0)

    function increment() {
        setCount(count + 1)
    }

    function decrement() {
        setCount(count - 1)
    }

    return (
        <div className="Counter">
            <span className="counterValue">{count}</span>
            <div>
                <button className="counterButton" onClick={increment}>+1</button>
                <button className="counterButton" onClick={decrement}>-1</button>
            </div>
        </div>);
}

export default Counter;