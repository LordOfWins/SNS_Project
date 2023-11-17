import Component1, {Component5} from "./Component1";
import Component2 from "./Component2";
import Component3 from "./Component3";
import Component4 from "./Component4";
import {Component} from "react";
import LearningJavaScript from "./LearningJavaScript";

export default class LearningComponent extends Component {
    render() {

        return (<div className="LearningComponent">
            <Component1/>
            <Component2/>
            <Component3/>
            <Component4/>
            <Component5/>
            <LearningJavaScript/>
        </div>)
    }
};