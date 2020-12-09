import React from 'react';
import SubmissionService from "../services/TaskService.js";

class TaskComponent extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            tasks: []
        }
    }

    componentDidMount() {
        SubmissionService.getTasks().then((response) => {
            this.setState({tasks: response.data})
        });
    }

    render() {
        return (
            <div>
                <h1 className="text-left"> COGNIZANT CHALLENGE</h1>
                <table className="table">
                    <thead>
                    <tr>
                        <td>SELECT TASK</td>
                        <td>DESCRIPTION</td>
                    </tr>
                    </thead>
                    <tbody>
                    {
                        this.state.tasks.map(
                            task =>
                                <tr key={task.name}>
                                    <td> {task.name}</td>
                                    <td> {task.description}</td>
                                </tr>
                        )
                    }
                    </tbody>
                </table>
            </div>
        )
    }
}

export default TaskComponent
