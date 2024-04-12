#!/bin/bash

# Get the last commit message
last_commit=$(git log -1 --pretty=%B)
#!/bin/bash

# Determine the type of version increment based on the commit message
if [[ $last_commit == *"BREAKING CHANGE"* ]]; then
    # Increment major version for breaking changes
    current_version=$(grep -oP '^version "\K\d+\.\d+\.\d+' build.gradle)
    echo "major $current_version"
    new_version=$(echo $current_version | awk -F. '{$1++; print $1 ".0.0"}')
elif [[ $last_commit == *"feat:"* ]]; then
    # Increment minor version for new features
    current_version=$(grep -oP '^version "\K\d+\.\d+\.\d+' build.gradle)
    echo "minor $current_version"
    new_version=$(echo $current_version | awk -F. '{$2++; print $1 "." $2 ".0"}')
else
    # Increment patch version for other changes
    current_version=$(grep -oP '^version "\K\d+\.\d+\.\d+' build.gradle)
    echo "$current_version"
    new_version=$(echo $current_version | awk -F. '{$3++; print $1 "." $2 "." $3}')
fi
echo "$new_version"

echo "New version: $new_version"


# Update the version in the build.gradle file
sed -i "s/version \"$current_version\"/version \"$new_version\"/" build.gradle

# Echo the new version
echo "$new_version"
