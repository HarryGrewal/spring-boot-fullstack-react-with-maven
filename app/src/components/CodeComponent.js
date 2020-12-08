import React, {Component} from 'react';

class CodeComponent extends Component {
    constructor(props) {
        super(props);
        this.state = {
            task: []
        }
    }

    render() {
        return <div>
            <h2 className={"textarea"}> Code Solution</h2>
            <textarea id="code"/>
            <button id="run">Run</button>
        </div>;
    }
}

export default CodeComponent;

