# Buddy Android Project

This guide provides instructions for setting up and running the Buddy Android project.

## 1. Initialize and Update Git Submodules

This project uses Git submodules. Before building, you need to initialize and update them.

```bash
git submodule update --init --recursive
```

## 2. Configure BASE_URL in local.properties

To connect the application to the backend, you need to define the `BASE_URL` in your `local.properties` file.

1. Create a file named `local.properties` in the root directory of the project if it doesn't already exist.
2. Add the following line to `local.properties`, replacing `YOUR_BASE_URL_HERE` with the actual base URL of your backend API:

```properties
BASE_URL="YOUR_BASE_URL_HERE"
```

**Example:**

```properties
BASE_URL="http://192.168.1.100:8080/"
```

Replace `http://192.168.1.100:8080/` with the appropriate URL for your local or remote backend server.