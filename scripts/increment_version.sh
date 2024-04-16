#!/bin/bash

# Get the last commit message
last_commit=$(git log -1 --pretty=%B)
#!/bin/bash

# Determine the type of version increment based on the commit message
current_version=$(grep -oP "version\s*=\s*'\K\d+\.\d+\.\d+" build.gradle)
if [[ $last_commit == *"BREAKING CHANGE"* ]]; then
    # Increment major version for breaking changes
    new_version=$(echo "$current_version" | awk -F. '{$1++; print $1 ".0.0"}')
elif [[ $last_commit == *"feat:"* ]]; then
    # Increment minor version for new features
    new_version=$(echo "$current_version" | awk -F. '{$2++; print $1 "." $2 ".0"}')
else
    # Increment patch version for other changes
    # shellcheck disable=SC2086
    new_version=$(echo $current_version | awk -F. '{$3++; print $1 "." $2 "." $3}')
fi

# Update the version in the build.gradle file
sed -i "s/version = '$current_version'/version = '$new_version'/" build.gradle

# Echo the new version
echo "$new_version"
