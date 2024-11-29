package controller;
/*
  @author <Nguyen Minh Phuong - s4063236>
 */

import model.Host;

import java.util.HashSet;

/**
 * Interface for managing hosts.
 */
public interface HostManagerController {
    /**
     * Retrieves all hosts.
     *
     * @return A set of all hosts.
     */
    HashSet<Host> getAllHosts();

    /**
     * Retrieves a host by its unique identifier.
     *
     * @param hostId The unique identifier of the host.
     * @return The host with the specified ID, or null if not found.
     */
    Host getHostByID(String hostId);

    /**
     * Retrieves hosts by their full name.
     *
     * @param fullName The full name of the host.
     * @return A set of hosts with the specified full name.
     */
    HashSet<Host> getHostByFullName(String fullName);

    /**
     * Retrieves a host by its contact information.
     *
     * @param contactInformation The contact information of the host.
     * @return The host with the specified contact information, or null if not found.
     */
    Host getHostByContactInformation(String contactInformation);

    /**
     * Adds a new host.
     *
     * @param host The host to be added.
     * @return true if the host was added successfully, false otherwise.
     */
    boolean addHost(Host host);

    /**
     * Updates an existing host.
     *
     * @param host The host with updated details.
     * @return true if the host was updated successfully, false otherwise.
     */
    boolean updateHost(Host host);

    /**
     * Deletes a host by its unique identifier.
     *
     * @param hostId The unique identifier of the host to be deleted.
     * @return true if the host was deleted successfully, false otherwise.
     */
    boolean deleteHost(String hostId);
}