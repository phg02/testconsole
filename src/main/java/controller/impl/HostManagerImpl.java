package controller.impl;
/*
  @author <Nguyen Minh Phuong - s4063236>
 */

import controller.HostManagerController;
import model.Host;
import util.FileHandler;

import java.util.HashSet;
import java.util.stream.Collectors;

/**
 * Implementation of the HostManagerController interface.
 * Manages hosts using a file handler.
 */
public class HostManagerImpl implements HostManagerController {
    private HashSet<Host> hosts;
    private FileHandler fileHandler;

    /**
     * Constructor to initialize the file handler and load hosts.
     *
     * @param fileHandler The file handler to load and save hosts.
     */
    public HostManagerImpl(FileHandler fileHandler) {
        this.fileHandler = fileHandler;
        hosts = this.fileHandler.getHostData();
    }

    /**
     * Retrieves all hosts.
     *
     * @return A set of all hosts.
     */
    @Override
    public HashSet<Host> getAllHosts() {
        return hosts;
    }

    /**
     * Retrieves a host by its unique identifier.
     *
     * @param hostId The unique identifier of the host.
     * @return The host with the specified ID, or null if not found.
     */
    @Override
    public Host getHostByID(String hostId) {
        return hosts.stream().filter(host -> host.getId().equals(hostId)).findFirst().orElse(null);
    }

    /**
     * Retrieves hosts by their full name.
     *
     * @param fullName The full name of the host.
     * @return A set of hosts with the specified full name.
     */
    @Override
    public HashSet<Host> getHostByFullName(String fullName) {
        return (HashSet<Host>) hosts.stream().filter(host -> host.getFullName().equals(fullName)).collect(Collectors.toSet());
    }

    /**
     * Retrieves a host by its contact information.
     *
     * @param contactInformation The contact information of the host.
     * @return The host with the specified contact information, or null if not found.
     */
    @Override
    public Host getHostByContactInformation(String contactInformation) {
        return hosts.stream().filter(host -> host.getContactInformation().equals(contactInformation)).findFirst().orElse(null);
    }

    /**
     * Adds a new host.
     *
     * @param host The host to be added.
     * @return true if the host was added successfully, false otherwise.
     */
    @Override
    public boolean addHost(Host host) {
        return false;
    }

    /**
     * Updates an existing host.
     *
     * @param host The host with updated details.
     * @return true if the host was updated successfully, false otherwise.
     */
    @Override
    public boolean updateHost(Host host) {
        return false;
    }

    /**
     * Deletes a host by its unique identifier.
     *
     * @param hostId The unique identifier of the host to be deleted.
     * @return true if the host was deleted successfully, false otherwise.
     */
    @Override
    public boolean deleteHost(String hostId) {
        return false;
    }
}