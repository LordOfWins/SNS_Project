import PropTypes from "prop-types";

export function CounterButton({by, incrementParent, decrementParent}) {

    return (
        <div className="CounterButton">
            <div>
                <button className="counterButton" onClick={() => incrementParent(by)}>+{by}</button>
                <button className="counterButton" onClick={() => decrementParent(by)}>-{by}</button>
            </div>
        </div>);
}

CounterButton.propTypes = {
    incrementParent: PropTypes.func
}

CounterButton.propTypes = {
    decrementParent: PropTypes.func
}

CounterButton.propTypes = {
    by: PropTypes.number
}

CounterButton.defaultProps = {
    by: 1
}