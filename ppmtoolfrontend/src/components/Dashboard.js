import React, { Component } from "react";
import ProjectItem from "./Project/ProjectItem";

// class based components are components that can take props/properties

class Dashboard extends Component {
  render() {
    return (
      <div>
        <h1 className="alert alert-warning">Welcome to the Dashboard</h1>
        <ProjectItem />

        <ProjectItem />

        <ProjectItem />
      </div>
    );
  }
}

export default Dashboard;
