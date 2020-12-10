import axios from 'axios'

const TASKS_REST_GET_API_URL = 'http://localhost:8080/task/getAllTasks';
const TASKS_REST_POST_API_URL = 'http://localhost:8080/task/submitTask';

class TaskService {

    getTasks() {
        return axios.get(TASKS_REST_GET_API_URL);
    }

    postTask() {

    }
}

export default new TaskService();
