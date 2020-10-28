package seedu.address.model.policy;

import static java.util.Objects.requireNonNull;

import java.util.Hashtable;

import seedu.address.model.person.exceptions.DuplicatePersonException;

public class PolicyList {
    private final Hashtable<String, Policy> policies;

    /**
     * Constructs a {@code PolicyList} from a HashTable.
     */
    public PolicyList(Hashtable<String, Policy> policies) {
        requireNonNull(policies);
        this.policies = policies;
    }

    public PolicyList() {
        policies = new Hashtable<>();
    }

    /**
     * Returns true if the list contains an equivalent person as the given argument.
     */
    public boolean contains(Policy toCheck) {
        requireNonNull(toCheck);
        return policies.contains(toCheck);
    }

    /**
     * Adds a {@link Policy} to policies.
     * @param toAdd is required to be non null.
     */
    public void add(Policy toAdd) {
        requireNonNull(toAdd);
        if (contains(toAdd)) {
            throw new DuplicatePersonException();
        }
        policies.put(toAdd.getPolicyName().policyName, toAdd);
    }

    /**
     * clear policies of all the data.
     */
    public void clear() {
        policies.clear();
    }

    /**
     * Returns an empty {@code PolicyList}
     */
    public static PolicyList createNewPolicyList() {
        Hashtable<String, Policy> policies = new Hashtable<>();
        return new PolicyList(policies);
    }

    /**
     * Returns a copy of the internal HashTable
     */
    public Hashtable<String, Policy> getHashtableCopy() {
        Hashtable<String, Policy> copy = new Hashtable<>();
        copy.putAll(policies);
        return copy;
    }

    /**
     * Returns the Policy in the hashtable if present using a {@code PolicyName}
     * else returns null.
     */
    public Policy getPolicy(PolicyName name) {
        return policies.get(name.policyName);
    }

    /**
     * Returns the Policy in the hashtable if present using String name,
     * else returns null.
     */
    public Policy getPolicy(String name) {
        return policies.get(name);
    }

    /**
     * Returns true if both Policys have the same values in the hashtable.
     */
    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof PolicyList // instanceof handles nulls
                && policies.equals(((PolicyList) other).getHashtableCopy()));
    }

    @Override
    public int hashCode() {
        return policies.hashCode();
    }
}