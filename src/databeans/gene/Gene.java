package databeans.gene;

public class Gene {
	String UID;
	String seqType;
	String accession;
	String version;
	String seqDataset;
	String speciesID;
	String status;
	
	public String getUID() {
		return UID;
	}
	public void setUID(String uID) {
		UID = uID;
	}
	public String getSeqType() {
		return seqType;
	}
	public void setSeqType(String seqType) {
		this.seqType = seqType;
	}
	public String getAccession() {
		return accession;
	}
	public void setAccession(String accession) {
		this.accession = accession;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getSeqDataset() {
		return seqDataset;
	}
	public void setSeqDataset(String seqDataset) {
		this.seqDataset = seqDataset;
	}
	public String getSpeciesID() {
		return speciesID;
	}
	public void setSpeciesID(String speciesID) {
		this.speciesID = speciesID;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return "Gene [UID=" + UID + ", seqType=" + seqType + ", accession="
				+ accession + ", version=" + version + ", seqDataset="
				+ seqDataset + ", speciesID=" + speciesID + ", status="
				+ status + "]";
	}
	
	public String toInsertStat() {
		return "Insert into gene(UID, seqType, accession, version, seqDataset, speciesID, status) values('" +
				UID + "', '" + seqType+ "', '" + accession + "', '" + version + "', '" + seqDataset + "', '" + speciesID + "', '" + status + "');";
	}
	
}
