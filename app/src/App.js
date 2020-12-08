import './App.css';
import UserComponent from "./components/UserComponent";
import SubmissionComponent from "./components/SubmissionComponent";
import CodeComponent from "./components/CodeComponent";

function App() {
    return (
        <div className="App">
            <SubmissionComponent/>
            <CodeComponent/>
            <UserComponent/>
        </div>
    );
}

export default App;
