import React from 'react';
import TaskService from "../services/TaskService.jsx";
import PropTypes from 'prop-types';

class TaskComponent extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            tasks: []
        }
    }

    componentDidMount() {
        TaskService.getTasks().then((response) => {
            this.setState({tasks: response.data});
        });
    }




    render() {
        let taskList = [];
        this.state.tasks.map(
            task => (taskList.push(task.name))
        );
        return (
            <div>
                {taskList}
            </div>
        )
    }

}
TaskComponent.defaultProps = {
        by : 1
}
TaskComponent.propTypes = {
    by: PropTypes.number
}
export default TaskComponent;
