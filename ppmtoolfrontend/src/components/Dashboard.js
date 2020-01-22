import React, { Component } from "react";
import ProjectItem from "./Project/ProjectItem";
import CreateProjectButton from "./Project/CreateProjectButton";

import { connect } from "react-redux";
import { getProjects } from "../actions/projectActions";
import PropTypes from "prop-types";

// class based components are components that can take props/properties

class Dashboard extends Component {
  componentDidMount() {
    this.props.getProjects();
  }

  render() {
    // const projectObject = {
    //   projectName: "ProjectName PROPS",
    //   projectIdentifer: "PROP",
    //   description: "description from PROPS"
    // };

    const projects = this.props.project.projects;

    return (
      <div className="projects">
        <div className="container">
          <div className="row">
            <div className="col-md-12">
              <h1 className="display-4 text-center">Projects</h1>
              <br />
              <CreateProjectButton />
              <br />
              <hr />
              {projects.map(project => (
                <ProjectItem key={project.id} project={project} />
              ))}
            </div>
          </div>
        </div>
      </div>
    );
  }
}

Dashboard.propTypes = {
  project: PropTypes.object.isRequired,
  getProjects: PropTypes.func.isRequired
};

const mapStateToProps = state => ({
  // project is coming from the combineReducers in index.js line 7 and extracting the projects array[] in projectReducers line 4.
  project: state.project
});

export default connect(mapStateToProps, { getProjects })(Dashboard);
