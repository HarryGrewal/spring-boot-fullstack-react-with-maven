import React from 'react';
import Select from 'react-select';
import SubmissionService from "../services/TaskService.jsx";

class TaskComponent extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            tasks: []
        }
    }

    componentDidMount() {
        SubmissionService.getTasks().then((response) => {
            this.setState({tasks: response.data});
        });
    }

    render() {
        return (
            <div>
            </div>
        )
    }
}

export default TaskComponent;
